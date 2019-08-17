package com.example.demo.Mapper;

import com.example.demo.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapping {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,tag,creator) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{tag},#{creator})")
    void createQuestion(Question question);
}
