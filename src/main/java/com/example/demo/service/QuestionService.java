package com.example.demo.service;
import com.example.demo.Mapper.QuestionMapping;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.dto.QuestionDTO;
import com.example.demo.model.Question;
import com.example.demo.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapping questionMapping;

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapping.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            /*questionDTO.setUser(user);
            questionDTO.setTitle(question.getTitle());
            questionDTO.setDescription(question.getDescription());
            questionDTO.setTag(question.getTag());
            questionDTO.setCreator(user.getId());
            questionDTO.setGmtCreate(question.getGmtCreate());
            questionDTO.setGmtModified(question.getGmtModified());
            questionDTO.setCommentCount(question.getCommentCount());
            questionDTO.setViewCount(question.getViewCount());
            questionDTO.setLikeCount(question.getLikeCount());*/
            BeanUtils.copyProperties(question,questionDTO);//复制
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
