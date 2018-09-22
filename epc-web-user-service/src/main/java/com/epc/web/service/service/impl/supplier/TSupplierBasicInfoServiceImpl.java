package com.epc.web.service.service.impl.supplier;

import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleFindSupplierByInfo;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.service.domain.supplier.TSupplierAttachment;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.domain.supplier.TSupplierBasicInfoCriteria;
import com.epc.web.service.domain.supplier.TSupplierDetailInfo;
import com.epc.web.service.mapper.supplier.TSupplierAttachmentMapper;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.web.service.service.supplier.TSupplierBasicInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 供应商对员工的相关操作
 * @Description:
 * @Author:         donghuan
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
public class TSupplierBasicInfoServiceImpl implements TSupplierBasicInfoService {

    private static final Logger LOGGER= LoggerFactory.getLogger(TSupplierBasicInfoServiceImpl.class);

    @Autowired
    private TSupplierBasicInfoMapper tSupplierBasicInfoMapper;
    @Autowired
    private TSupplierDetailInfoMapper tSupplierDetailInfoMapper;
    @Autowired
    private TSupplierAttachmentMapper tSupplierAttachmentMapper;

    /**
     * 注册供应商
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> registerSupplier(HandleSupplierDetail handleSupplierDetail) {

        Date date=new Date();

        //电话提出来
        String cellphone=handleSupplierDetail.getCellPhone();

        //将公司名称，电话，密码信息存入到这个表对象中
        TSupplierBasicInfo tSupplierBasicInfo=new TSupplierBasicInfo();
        //设置电话
        tSupplierBasicInfo.setCellphone(cellphone);
        //设置密码
        tSupplierBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(handleSupplierDetail.getPassword()));
        //设置状态
        tSupplierBasicInfo.setState(Const.STATE.COMMITTED);
        //设置角色
        tSupplierBasicInfo.setRole(Const.Role.ROLE_CORPORATION);
        //设置状态,已注册
        tSupplierBasicInfo.setState(Const.STATE.REGISTERED);
        //创建时间
        tSupplierBasicInfo.setCreateAt(date);
        //最后修改时间(预计注册时可能不需要，默认没有，只有当修改了才会有这个 修改时间)
        //tSupplierBasicInfo.setUpdateAt(new Date());

        int supplierBoss = tSupplierBasicInfoMapper.insertSelective(tSupplierBasicInfo);
        //查出这个这条已经插入的数据的id，得到这个供应商法人的id
        //根据电话来查询这个人的基本信息，从中得到id
        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andCellphoneEqualTo(cellphone);
        List<TSupplierBasicInfo> nowSupperBoss = tSupplierBasicInfoMapper.selectByExample(criteria);

//        TSupplierBasicInfoServiceImpl impl=new TSupplierBasicInfoServiceImpl();
//        TSupplierBasicInfo supplierByCellphone = impl.findSupplierByCellphone(cellphone);
//        Long id=supplierByCellphone.getSupplierId();.
        Long id=nowSupperBoss.get(0).getSupplierId();

        TSupplierDetailInfo tSupplierDetailInfo=new TSupplierDetailInfo();
        //在详情表中插入这个id
        tSupplierDetailInfo.setSupplierId(id);
        //设置公司名称
        tSupplierDetailInfo.setCompanyName(handleSupplierDetail.getCompanyName());
        //设置创建时间
        tSupplierDetailInfo.setCreateAt(date);

        int supplierBoss2 = tSupplierDetailInfoMapper.insertSelective(tSupplierDetailInfo);

        return (supplierBoss>0 && supplierBoss2>0)?Result.success(true):Result.success(false);
    }



    /**
     * 根据电话来查找一条记录,返回一个运营商法人基本记录
     */
    private TSupplierBasicInfo findSupplierByCellphone(String cellphone){
        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        if(StringUtils.isNotBlank(cellphone)){
            subCriteria.andCellphoneEqualTo(cellphone);
        }
        List<TSupplierBasicInfo> tSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
        return tSupplierBasicInfos.get(0);
    }

    /**
     * 根据员工的id来查询基本信息
     */
    @Override
    public Result<SupplierBasicInfoVO> fingSupplierBasicById(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        //得到supplierbasic表的id
        Long id= handleFindSupplierByInfo.getId();
        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
        SupplierBasicInfoVO vo=new SupplierBasicInfoVO();
        BeanUtils.copyProperties(handleFindSupplierByInfo,vo);
        return Result.success(vo);
    }


    /**
     * 根据电话来查找一条记录,返回一个记录
     */
    @Override
    public Result<SupplierBasicInfoVO> findSupplierByCellphone(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        String cellphone= handleFindSupplierByInfo.getCellPhone();

        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();

        if(StringUtils.isNotBlank(cellphone)){
            subCriteria.andCellphoneEqualTo(cellphone);
        }
        List<TSupplierBasicInfo> tSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
        SupplierBasicInfoVO vo=new SupplierBasicInfoVO();
        BeanUtils.copyProperties(tSupplierBasicInfos.get(0),vo);
        return Result.success(vo);
    }



    /**
     * 依据名字和电话查询用户信息
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<SupplierBasicInfoVO> findByName(HandleFindSupplierByInfo handleFindSupplierByInfo) {

        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        String name=handleFindSupplierByInfo.getName();
        String cellphone=handleFindSupplierByInfo.getCellPhone();
        if(StringUtils.isNotBlank(name)){
            subCriteria.andNameEqualTo(name);
        }
        if(StringUtils.isNotBlank(cellphone)){
            subCriteria.andCellphoneEqualTo(cellphone);
        }
        List<TSupplierBasicInfo> list = tSupplierBasicInfoMapper.selectByExample(criteria);
        SupplierBasicInfoVO vo=new SupplierBasicInfoVO();
        BeanUtils.copyProperties(list.get(0),vo);
        return Result.success(vo);
    }

    /**
     *  忘记密码
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> forgetPassword(HandleSupplierForgetPassword handleSupplierForgetPassword) {

        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        //得到手机号,查询数据库中有没有这条数据
        String cellphone=handleSupplierForgetPassword.getCellphone();
        if(StringUtils.isNotBlank(cellphone)){
            subCriteria.andCellphoneEqualTo(cellphone);
        }
        //查询出一条结果,然后将密码改掉
        List<TSupplierBasicInfo> listTSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
        //加密传过来的密码
        String newPassword = MD5Util.MD5EncodeUtf8(handleSupplierForgetPassword.getPassword());
        TSupplierBasicInfo tSupplierBasicInfo=listTSupplierBasicInfos.get(0);
        tSupplierBasicInfo.setPassword(newPassword);
        //将新数据更新到数据 库中
        return tSupplierBasicInfoMapper.updateByExampleSelective(tSupplierBasicInfo,criteria)>0?Result.<Boolean>success(true):Result.<Boolean>success(false);
    }



    /**
     * 供应商增加一个员工
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> createSupplierEmployee(HandlerSupplierAddEmployee handlerSupplierAddEmployee) {

        // 创建数据库插入对象
        TSupplierBasicInfo pojo=new TSupplierBasicInfo();
        //设置供应商的id
        pojo.setSupplierId(handlerSupplierAddEmployee.getSupplierId());
        //供应商状态3审核通过
        pojo.setState(Const.STATE.AUDIT_SUCCESS);
        //是否删除，0存在
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        //角色2员工
        pojo.setRole(Const.Role.ROLE_CUSTOMER);
        //设置名字
        pojo.setName(handlerSupplierAddEmployee.getName());
        //设置电话
        pojo.setCellphone(handlerSupplierAddEmployee.getCellphone());
        //设置密码
        pojo.setPassword(MD5Util.MD5EncodeUtf8(handlerSupplierAddEmployee.getPassword()));
        //创建时间
        pojo.setCreateAt(new Date());
        //最后修改时间
//        pojo.setUpdateAt(new Date());
        //返回成功或者失败
        try {
            return Result.success(tSupplierBasicInfoMapper.insertSelective(pojo)>0);
        }catch (BusinessException e){
            LOGGER.error("exception insertTSupplierBasicInfoMapper:{}",e);
            return Result.error(e.getMessage());
        }
    }


    /**
     *     通过id查询这个用户信息，得到用户提交的数据，并且设置到对应的实体类中
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> updateSupplierEmployeeById(HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById) {

        //通过这个员工的id来查询出他的所有信息
        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(handlerUpdateSupplierEmployeeById.getId());
        //将最新的名字传入进去
        tSupplierBasicInfo.setName(handlerUpdateSupplierEmployeeById.getName());
        //将最新的电话传入进去
        tSupplierBasicInfo.setCellphone(handlerUpdateSupplierEmployeeById.getCellphone());
        //将状态传入进去
        tSupplierBasicInfo.setIsDeleted(handlerUpdateSupplierEmployeeById.getIsDeleted());
        //将最新的时间存进去
        tSupplierBasicInfo.setUpdateAt(new Date());
        //存入数据库
        try{
            return Result.success(tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo)>0);
        }catch (BusinessException e){
            LOGGER.error("BusinessException updateSupplierEmployeeById : {}", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
    }


    /**
     * @Description:    根据员工的名字来匹配出符合条件的员工返回一个list
     * @Author:         donghuan
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(HandleFindSupplierByInfo handleFindSupplierByInfo) {

        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria criteria1 = criteria.createCriteria();

        //获取输入的名字,来进行模糊查询
        String where=handleFindSupplierByInfo.getName();
        //得到操作者本人的id，查出来的是这个供应商底下的员工列表
        Long supplierId=handleFindSupplierByInfo.getSupplierId();
        if(org.apache.commons.lang.StringUtils.isNotBlank(where)){
            criteria1.andNameLike("%"+where+"%");
        }
        criteria1.andSupplierIdEqualTo(supplierId);
        List<TSupplierBasicInfo> listTSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
        List<SupplierBasicInfoVO> listVo=new ArrayList<SupplierBasicInfoVO>();

        for(TSupplierBasicInfo tsupplierBasicInfo:listTSupplierBasicInfos){
            SupplierBasicInfoVO vo=new SupplierBasicInfoVO();
            BeanUtils.copyProperties(tsupplierBasicInfo,vo);
            listVo.add(vo);
        }
        return Result.success(listVo);
    }

    /**
     * 完善供应商信息
     * 肯定已经登陆成功，才能完善；根据本人的id来查询basic表，然后将填入的详情信息，分别存入另外两张表中
     */
    @Override
    public Result<Boolean> insertCompleteSupplierInfo(RoleDetailInfo roleDetailInfo) {
        Date date=new Date();
        TSupplierDetailInfo detailInfo = new TSupplierDetailInfo();
        BeanUtils.copyProperties(roleDetailInfo, detailInfo);
        //将basic表中的主键id（员工id）设置到detail表中为法人supplier_id
        detailInfo.setSupplierId(roleDetailInfo.getUserId());
        detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);

        TSupplierAttachment attachment = new TSupplierAttachment();
        attachment.setSupplierId(roleDetailInfo.getUserId());
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        try {
            tSupplierDetailInfoMapper.insertSelective(detailInfo);
            //带公章的授权书照片url
            attachment.setCertificateType(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getCertificateOfAuthorization());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //经办人(运营商员工)手持身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getOperatorIdCardFront());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //法人身份证反面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getLegalIdCardOther());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //法人身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getLegalIdCardPositive());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //营业执照照片url
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getBusinessLicense());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //资质证书url
            attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getQualificationCertificate());
            tSupplierAttachmentMapper.insertSelective(attachment);
            return Result.success();
        }catch (BusinessException e) {
            LOGGER.error("BusinessException insertSupplierDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException insertSupplierAttachmentInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }


}
