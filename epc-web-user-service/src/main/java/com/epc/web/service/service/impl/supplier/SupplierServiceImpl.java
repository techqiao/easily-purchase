package com.epc.web.service.service.impl.supplier;

import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleFindSupplierByInfo;
import com.epc.web.facade.supplier.vo.SupplierAttachmentAndDetailVO;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.service.domain.supplier.*;
import com.epc.web.service.mapper.supplier.TSupplierAttachmentMapper;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.web.service.service.supplier.SupplierService;
import jdk.nashorn.internal.ir.ReturnNode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.security.util.AuthResources_it;

import java.text.SimpleDateFormat;
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
public class SupplierServiceImpl implements SupplierService {

    private static final Logger LOGGER= LoggerFactory.getLogger(SupplierServiceImpl.class);

    @Autowired
    private TSupplierBasicInfoMapper tSupplierBasicInfoMapper;
    @Autowired
    private TSupplierDetailInfoMapper tSupplierDetailInfoMapper;
    @Autowired
    private TSupplierAttachmentMapper tSupplierAttachmentMapper;

    /**
     * 注册供应商
     *  {业务：第一次只需要填写电话及密码就行，注册完成登陆成功后，可以做后续的完善信息工作
     *          所以目前，只操作一张基本信息表就行，等完善信息时，操作三张即可
     *  }
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> registerSupplier(HandleSupplierDetail handleSupplierDetail) {
        Date date=new Date();

        //电话提出来
        String cellphone=handleSupplierDetail.getCellphone();
        //将电话，密码信息存入到这个表对象中
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
        //最后修改时间
        tSupplierBasicInfo.setUpdateAt(date);

        SupplierServiceImpl serviceImpl=new SupplierServiceImpl();
        try{
            //将基本注册信息数据存入到数据库
            tSupplierBasicInfoMapper.insertSelective(tSupplierBasicInfo);
            Long id=tSupplierBasicInfo.getId();
            tSupplierBasicInfo.setSupplierId(id);
            return tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo)>0 ? Result.success(true) : Result.success(false);
        }catch (BusinessException e){
            LOGGER.error("tSupplierBasicInfoMapper.insertSelective:{}",e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e) {
            LOGGER.error("tSupplierBasicInfoMapper.insertSelective:{}", e);
            return Result.error(e.getMessage());
        }
    }



    /**
     * 暂时没用,不知道后期有没有这个需求
     *   依据 用户角色 是法人的情况下，来查出 supplier_id,
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Long> findSupplierIdByRole(Integer role){
        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        if(role!=null && role==0){
            subCriteria.andRoleEqualTo(role);
        }
        try {
            return Result.success(tSupplierBasicInfoMapper.selectByExample(criteria).get(0).getId());
        }catch (BusinessException e){
            LOGGER.error("tSupplierBasicInfoMapper.selectByExample : {}",e);
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }catch (Exception e){
            LOGGER.error("tSupplierBasicInfoMapper.selectByExample : {}",e);
            return Result.error(e.getMessage());
        }
    }

    /**
     * 根据员工的id来查询基本信息
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<SupplierBasicInfoVO> findSupplierBasicById(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        //得到supplierbasic表的id
        Long id= handleFindSupplierByInfo.getId();
        if(id!=null){
            try{
                TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
                //将时间格式化
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss a");
                String createAt = format.format(tSupplierBasicInfo.getCreateAt());
                String updateAt = format.format(tSupplierBasicInfo.getUpdateAt());
                SupplierBasicInfoVO vo=new SupplierBasicInfoVO();
                vo.setCreateAt(createAt);
                vo.setUpdateAt(updateAt);
                BeanUtils.copyProperties(tSupplierBasicInfo,vo);
                return Result.success(vo);
            }catch (BusinessException e){
                LOGGER.error("tSupplierBasicInfoMapper.selectByPrimaryKey : {}",e);
                return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
            }catch (Exception e){
                LOGGER.error("tSupplierBasicInfoMapper.selectByPrimaryKey : {}",e);
                return Result.error(e.getMessage());
            }
        }else{
            LOGGER.error("handleFindSupplierByInfo.getId() {参数为null}");
            return Result.error(ErrorMessagesEnum.ID_ILLEAGAL);
        }
    }

    /**
     * 根据员工id来删除一个员工
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> deleteSupplierEmployeeById(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        Long id=handleFindSupplierByInfo.getId();
        if(id!=null){
            try{
                return tSupplierBasicInfoMapper.deleteByPrimaryKey(id)>0 ? Result.<Boolean>success(true) : Result.<Boolean>success(false);
            }catch (BusinessException e){
                LOGGER.error("tSupplierBasicInfoMapper.deleteByPrimaryKey :{}",e);
                return Result.error(ErrorMessagesEnum.DELETE_FAILURE);
            }catch (Exception e){
                LOGGER.error("tSupplierBasicInfoMapper.deleteByPrimaryKey :{}",e);
                return Result.error(e.getMessage());
            }
        }else{
            return Result.error("handleFindSupplierByInfo.getId() : {参数为空}");
        }
    }

    /**
     * 根据电话来查找一条记录,返回一个运营商法人基本记录
     */
//    private TSupplierBasicInfo findSupplierByCellphone(String cellphone){
//        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
//        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
//        if(StringUtils.isNotBlank(cellphone)){
//            subCriteria.andCellphoneEqualTo(cellphone);
//        }
//        List<TSupplierBasicInfo> tSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
//        return tSupplierBasicInfos.get(0);
//    }

    /**
     * 员工id来查询（公司法人supplier_id） 公司详情（包括附件）
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<SupplierAttachmentAndDetailVO> findSupplierDetailByEmployee(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        //得到员工的id
        Long id=handleFindSupplierByInfo.getId();
        TSupplierBasicInfo supplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
        //得到法人supplier_id
        Long supplierId = supplierBasicInfo.getSupplierId();

        /**
         * 然后在basic同一个表中将法人的名字，电话，状态，角色 ，创建时间，更新时间都查出来
         * 因为supplier_id与id一样
         */
        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(supplierId);

        //依据员工的法人id来查询另外两张表，supplier_detail; supplier_attachment

        TSupplierAttachmentCriteria criteriaAtt=new TSupplierAttachmentCriteria();
        TSupplierAttachmentCriteria.Criteria subCriteria = criteriaAtt.createCriteria();

        TSupplierDetailInfoCriteria criteriaDetail=new TSupplierDetailInfoCriteria();
        TSupplierDetailInfoCriteria.Criteria subCriteriaDetail = criteriaDetail.createCriteria();

        if(supplierId!=null){
            subCriteria.andSupplierIdEqualTo(supplierId);
            subCriteriaDetail.andSupplierIdEqualTo(supplierId);
        }
        TSupplierDetailInfo tSupplierDetailInfos = tSupplierDetailInfoMapper.selectByExample(criteriaDetail).get(0);
        //测试
//        System.out.println(tSupplierDetailInfos.getSupplierId()+"\n"+tSupplierDetailInfos.getPublicBanAccountNumber()+"\n"+
//            tSupplierDetailInfos.getPublicBankName()+"\n"+tSupplierDetailInfos.getId()+"\n"+tSupplierDetailInfos.getCompanyName()
//        );

        List<TSupplierAttachment> tSupplierAttachments = tSupplierAttachmentMapper.selectByExample(criteriaAtt);

        RoleDetailInfo roleDetailInfo=new RoleDetailInfo();

        for(TSupplierAttachment ts:tSupplierAttachments){
            if(ts.getCertificateType().equals(AttachmentEnum.BUSINESS_LICENSE.getCode())){
                //营业执照照片url
                roleDetailInfo.setBusinessLicense(ts.getCertificateFilePath());
                roleDetailInfo.setBusinessLicenseNumber(ts.getCertificateNumber());
                continue;
            }
            if(ts.getCertificateType().equals(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode())){
                //资质证书url
                roleDetailInfo.setQualificationCertificate(ts.getCertificateFilePath());
                roleDetailInfo.setQualificationCertificateNumber(ts.getCertificateNumber());
                continue;
            }
            if(ts.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode())){
                //法人身份证正面照片url
                roleDetailInfo.setLegalIdCardPositive(ts.getCertificateFilePath());
                roleDetailInfo.setLegalIdCardPositiveNumber(ts.getCertificateNumber());
                continue;
            }
            if(ts.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode())){
                //法人身份证反面照片url
                roleDetailInfo.setLegalIdCardOther(ts.getCertificateFilePath());
                continue;
            }
            if(ts.getCertificateType().equals(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode())){
                //经办人(运营商员工)手持身份证正面照片url
                roleDetailInfo.setOperatorIdCardFront(ts.getCertificateFilePath());
                roleDetailInfo.setOperatorIdCardFrontNumber(ts.getCertificateNumber());
                continue;
            }
            if(ts.getCertificateType().equals(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode())){
                //带公章的授权书照片url
                roleDetailInfo.setCertificateOfAuthorization(ts.getCertificateFilePath());
                roleDetailInfo.setCertificateOfAuthorizationNumber(ts.getCertificateNumber());
                continue;
            }
        }
        SupplierAttachmentAndDetailVO vo=new SupplierAttachmentAndDetailVO();
        //测试
//        System.out.println(tSupplierDetailInfos.getSupplierId()+"\n"+tSupplierDetailInfos.getPublicBanAccountNumber()+"\n"+
//            tSupplierDetailInfos.getPublicBankName()+"\n"+tSupplierDetailInfos.getId()+"\n"+tSupplierDetailInfos.getCompanyName()
//        );


//        vo.setName(tSupplierBasicInfo.getName());
//        vo.setCellphone(tSupplierBasicInfo.getCellphone());
//        vo.setState(tSupplierBasicInfo.getState());
//        vo.setRole(tSupplierBasicInfo.getRole());


        //将附件的所有信息复制到返回类中
        BeanUtils.copyProperties(roleDetailInfo,vo);

        //将依据supplier_id查询出来detail表中信息copy到返回类中
        BeanUtils.copyProperties(tSupplierDetailInfos,vo);

        //将法人的基本信息复制到返回类中
        BeanUtils.copyProperties(tSupplierBasicInfo,vo);

        //创建时间与更新时间取的是basic表中的时间
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss a");
        String createAt = format.format(tSupplierBasicInfo.getCreateAt());
        String updateAt=format.format(tSupplierBasicInfo.getUpdateAt());
        vo.setCreateAt(createAt);
        vo.setUpdateAt(updateAt);


        return Result.success(vo);
    }


    /**
     * 根据电话来查找一条记录,返回一个基本信息
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<SupplierBasicInfoVO> findSupplierByCellphone(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        String cellphone= handleFindSupplierByInfo.getCellphone();

        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();

        if(StringUtils.isNotBlank(cellphone)){
            subCriteria.andCellphoneEqualTo(cellphone);
            try{
                List<TSupplierBasicInfo> tSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
                TSupplierBasicInfo single = tSupplierBasicInfos.get(0);
                SupplierBasicInfoVO vo=new SupplierBasicInfoVO();
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss a");
                vo.setCreateAt(format.format(single.getCreateAt()));
                vo.setUpdateAt(format.format(single.getUpdateAt()));
                BeanUtils.copyProperties(single,vo);
                return Result.success(vo);
            }catch (BusinessException e){
                LOGGER.error("tSupplierBasicInfoMapper.selectByExample : {}",e);
                return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
            }catch (Exception e){
                LOGGER.error("tSupplierBasicInfoMapper.selectByExample : {}",e);
                return Result.error(e.getMessage());
            }
        }else{
            return Result.error("StringUtils.isNotBlank(cellphone) : {参数为空}");
        }
    }



    /**
     * 依据名字和电话查询用户信息
     */
//    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
//    public Result<SupplierBasicInfoVO> findByName(HandleFindSupplierByInfo handleFindSupplierByInfo) {
//
//        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
//        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
//        String name=handleFindSupplierByInfo.getName();
//        String cellphone=handleFindSupplierByInfo.getCellphone();
//        if(StringUtils.isNotBlank(name)){
//            subCriteria.andNameEqualTo(name);
//        }
//        if(StringUtils.isNotBlank(cellphone)){
//            subCriteria.andCellphoneEqualTo(cellphone);
//        }
//        List<TSupplierBasicInfo> list = tSupplierBasicInfoMapper.selectByExample(criteria);
//        SupplierBasicInfoVO vo=new SupplierBasicInfoVO();
//        BeanUtils.copyProperties(list.get(0),vo);
//        return Result.success(vo);
//    }

    /**
     *  忘记密码
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> forgetPassword(HandleSupplierForgetPassword handleSupplierForgetPassword) {
//        System.out.println("进来忘记密码方法了");
        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        //得到手机号,查询数据库中有没有这条数据
        String cellphone=handleSupplierForgetPassword.getCellphone();
        if(StringUtils.isNotBlank(cellphone)){
            subCriteria.andCellphoneEqualTo(cellphone);
//            System.out.println("电话不为空"+cellphone);
        }
        //查询出一条结果,然后将密码改掉
        List<TSupplierBasicInfo> listTSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
        System.out.println(listTSupplierBasicInfos.get(0).getPassword());
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
     *  供应商修改员工
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
        String name=handleFindSupplierByInfo.getName();
        //得到操作者本人的id，查出来的是这个供应商底下的员工列表
        Long supplierId=handleFindSupplierByInfo.getSupplierId();
        if(org.apache.commons.lang.StringUtils.isNotBlank(name)){
            criteria1.andNameLike("%"+name+"%");
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
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> insertCompleteSupplierInfo(RoleDetailInfo roleDetailInfo) {

        Date date=new Date();

        //设置供应商详情表中的一些信息，并插入一条数据到detail
        TSupplierDetailInfo tSupplierDetailInfo = new TSupplierDetailInfo();
        BeanUtils.copyProperties(roleDetailInfo, tSupplierDetailInfo);
        //将basic表中的主键id（员工id）设置到detail表中为法人supplier_id
        tSupplierDetailInfo.setSupplierId(roleDetailInfo.getSupplierId());
        tSupplierDetailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        tSupplierDetailInfo.setCreateAt(date);
        tSupplierDetailInfo.setUpdateAt(date);

        TSupplierAttachment attachment = new TSupplierAttachment();
        attachment.setSupplierId(roleDetailInfo.getSupplierId());
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        try {

            tSupplierDetailInfoMapper.insertSelective(tSupplierDetailInfo);

            //证书类型(带公章的授权书照片)
            attachment.setCertificateType(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode());
            //带公章的授权书照片url
            attachment.setCertificateFilePath(roleDetailInfo.getCertificateOfAuthorization());
            //公章证书名字
            attachment.setCertificateName(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getDesc());
            //公章证书号码
            attachment.setCertificateNumber(roleDetailInfo.getCertificateOfAuthorizationNumber());
            tSupplierAttachmentMapper.insertSelective(attachment); //插入一条数据

            //证书类型(经办人(运营商员工)手持身份证正面照片)
            attachment.setCertificateType(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode());
            //经办人(运营商员工)手持身份证正面照片url
            attachment.setCertificateFilePath(roleDetailInfo.getOperatorIdCardFront());
            //证书名字
            attachment.setCertificateName(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getDesc());
            //证书上的号码
            attachment.setCertificateNumber(roleDetailInfo.getOperatorIdCardFrontNumber());
            tSupplierAttachmentMapper.insertSelective(attachment);

            //证书类型(法人身份证反面照片)
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            //法人身份证反面照片url
            attachment.setCertificateFilePath(roleDetailInfo.getLegalIdCardOther());
            //证书名字
            attachment.setCertificateName(AttachmentEnum.LEGAL_ID_CARD_OTHER.getDesc());
            tSupplierAttachmentMapper.insertSelective(attachment);

            //证书类型(法人身份证正面照片)
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            //法人身份证正面照片url
            attachment.setCertificateFilePath(roleDetailInfo.getLegalIdCardPositive());
            //证书名字
            attachment.setCertificateName(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getDesc());
            //证书号码
            attachment.setCertificateNumber(roleDetailInfo.getLegalIdCardPositiveNumber());
            tSupplierAttachmentMapper.insertSelective(attachment);

            //证书类型(营业执照照片)
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            //营业执照照片url
            attachment.setCertificateFilePath(roleDetailInfo.getBusinessLicense());
            //证书名称
            attachment.setCertificateName(AttachmentEnum.BUSINESS_LICENSE.getDesc());
            //证书号码
            attachment.setCertificateNumber(roleDetailInfo.getBusinessLicenseNumber());
            tSupplierAttachmentMapper.insertSelective(attachment);

            //证书类型(资质证书)
            attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
            //资质证书url
            attachment.setCertificateFilePath(roleDetailInfo.getQualificationCertificate());
            //证书名称
            attachment.setCertificateName(AttachmentEnum.QUALIFICATION_CERTIFICATE.getDesc());
            //证书号码
            attachment.setCertificateNumber(roleDetailInfo.getQualificationCertificateNumber());
            tSupplierAttachmentMapper.insertSelective(attachment);



            //依据客户端传过来的id来查询对detail attachment 来操作
            TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(roleDetailInfo.getSupplierId());
            //设置法人姓名
            tSupplierBasicInfo.setName(roleDetailInfo.getName());
            //设置状态为（state）2:已提交
            tSupplierBasicInfo.setState(Const.STATE.COMMITTED);
            //设置更新日期
            tSupplierBasicInfo.setUpdateAt(date);

            //将修改（增加）的数据更新到其中
            tSupplierBasicInfoMapper.updateByPrimaryKey(tSupplierBasicInfo);


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
