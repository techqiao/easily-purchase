package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.BSaleDocuments;
import com.epc.tendering.service.domain.bid.BSaleDocumentsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface BSaleDocumentsMapper {
    int countByExample(BSaleDocumentsCriteria example);

    int deleteByExample(BSaleDocumentsCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BSaleDocuments record);

    int insertSelective(BSaleDocuments record);

    List<BSaleDocuments> selectByExampleWithRowbounds(BSaleDocumentsCriteria example, RowBounds rowBounds);

    List<BSaleDocuments> selectByExample(BSaleDocumentsCriteria example);

    BSaleDocuments selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BSaleDocuments record, @Param("example") BSaleDocumentsCriteria example);

    int updateByExample(@Param("record") BSaleDocuments record, @Param("example") BSaleDocumentsCriteria example);

    int updateByPrimaryKeySelective(BSaleDocuments record);

    int updateByPrimaryKey(BSaleDocuments record);

    @Select("Select b.bidding_documents_download_url from b_sale_documents b where b.procurement_project_id=#{procurementProjectId}")
    String getUrl(Long procurementProjectId);

    /**
     * 招标文件为已发布 完成
     * @param procurementProjectId
     * @return
     */
    @Select("Select b.id from b_sale_documents b where b.procurement_project_id =#{procurementProjectId} and b.process_status='released'")
    Long getId(Long procurementProjectId);
}