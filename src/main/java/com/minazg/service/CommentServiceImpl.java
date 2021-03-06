package com.minazg.service;

import com.minazg.model.Comment;
import com.minazg.repository.CommentRepository;
import com.minazg.util.HelperUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserService userService;

    @Autowired
    HelperUtils helperUtils;

    public List<Comment> findAll(){

        return (List<Comment>) commentRepository.findAll();
    }

    public List<Comment> loadComment(Long componentId, String componentType){
        List<Comment> comments = (List<Comment>) commentRepository.findByComponentIdAndComponentTypeOrderByDateCommentedDesc(componentId, componentType);
        for(Comment comment : comments){
            Hibernate.initialize(comment.getProposer());
        }
        return comments;
    }

    public Long countComments(Long componentId, String componentType){
        return commentRepository.countByComponentIdAndComponentType(componentId,componentType);
    }

    public Comment save(Comment comment){
        comment.setProposer(userService.getCurrentAuthenticatedUser());
        comment.setDateCommented(new Date());
        comment = commentRepository.save(comment);
        Hibernate.initialize(comment.getProposer());
        Hibernate.initialize(comment.getProposer().getUserRoles());
        return comment;
    }

    public void delete(Long userId, Long commentId ){
        commentRepository.deleteByIdAndProposerId(commentId,userService.getCurrentAuthenticatedUser().getId());
    }
}
