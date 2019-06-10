package edu.neu.hoso.model;

import edu.neu.hoso.example.ExaminationFmedicalItemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ExaminationFmedicalItemsMapper {
    int countByExample(ExaminationFmedicalItemsExample example);

    int deleteByExample(ExaminationFmedicalItemsExample example);

    @Delete({
        "delete from examination_fmedical_items",
        "where Examination_Fmedical_Items_ID = #{examinationFmedicalItemsId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer examinationFmedicalItemsId);

    @Insert({
        "insert into examination_fmedical_items (Examination_Fmedical_Items_ID, ",
        "Examination_ID, Fmedical_Items_ID, ",
        "Registration_Status, Purpose_Requirements, ",
        "Quantity, Actual_Quantity, ",
        "Examination_Result_ID, Expense_Items_ID)",
        "values (#{examinationFmedicalItemsId,jdbcType=INTEGER}, ",
        "#{examinationId,jdbcType=INTEGER}, #{fmedicalItemsId,jdbcType=INTEGER}, ",
        "#{registrationStatus,jdbcType=CHAR}, #{purposeRequirements,jdbcType=VARCHAR}, ",
        "#{quantity,jdbcType=INTEGER}, #{actualQuantity,jdbcType=INTEGER}, ",
        "#{examinationResultId,jdbcType=INTEGER}, #{expenseItemsId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="examinationFmedicalItemsId", before=true, resultType=Integer.class)
    int insert(ExaminationFmedicalItems record);

    int insertSelective(ExaminationFmedicalItems record);

    List<ExaminationFmedicalItems> selectByExample(ExaminationFmedicalItemsExample example);

    @Select({
        "select",
        "Examination_Fmedical_Items_ID, Examination_ID, Fmedical_Items_ID, Registration_Status, ",
        "Purpose_Requirements, Quantity, Actual_Quantity, Examination_Result_ID, Expense_Items_ID",
        "from examination_fmedical_items",
        "where Examination_Fmedical_Items_ID = #{examinationFmedicalItemsId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    ExaminationFmedicalItems selectByPrimaryKey(Integer examinationFmedicalItemsId);

    int updateByExampleSelective(@Param("record") ExaminationFmedicalItems record, @Param("example") ExaminationFmedicalItemsExample example);

    int updateByExample(@Param("record") ExaminationFmedicalItems record, @Param("example") ExaminationFmedicalItemsExample example);

    int updateByPrimaryKeySelective(ExaminationFmedicalItems record);

    @Update({
        "update examination_fmedical_items",
        "set Examination_ID = #{examinationId,jdbcType=INTEGER},",
          "Fmedical_Items_ID = #{fmedicalItemsId,jdbcType=INTEGER},",
          "Registration_Status = #{registrationStatus,jdbcType=CHAR},",
          "Purpose_Requirements = #{purposeRequirements,jdbcType=VARCHAR},",
          "Quantity = #{quantity,jdbcType=INTEGER},",
          "Actual_Quantity = #{actualQuantity,jdbcType=INTEGER},",
          "Examination_Result_ID = #{examinationResultId,jdbcType=INTEGER},",
          "Expense_Items_ID = #{expenseItemsId,jdbcType=INTEGER}",
        "where Examination_Fmedical_Items_ID = #{examinationFmedicalItemsId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ExaminationFmedicalItems record);
}