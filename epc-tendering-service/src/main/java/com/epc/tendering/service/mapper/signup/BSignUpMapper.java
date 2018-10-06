package com.epc.tendering.service.mapper.signup;

import com.epc.tendering.service.domain.signup.BSignUp;
import com.epc.tendering.service.domain.signup.BSignUpCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BSignUpMapper {
    int countByExample(BSignUpCriteria example);

    int deleteByExample(BSignUpCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BSignUp record);

    int insertSelective(BSignUp record);

    List<BSignUp> selectByExampleWithRowbounds(BSignUpCriteria example, RowBounds rowBounds);

    List<BSignUp> selectByExample(BSignUpCriteria example);

    BSignUp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BSignUp record, @Param("example") BSignUpCriteria example);

    int updateByExample(@Param("record") BSignUp record, @Param("example") BSignUpCriteria example);

    int updateByPrimaryKeySelective(BSignUp record);

    int updateByPrimaryKey(BSignUp record);
}