package com.ssafy.db.repository.board;

import com.ssafy.db.entity.board.BoardCategory;
import com.ssafy.db.entity.board.Code;
import com.ssafy.db.entity.board.DogInformation;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DogInformationSpecification {


    public static Specification<DogInformation> likeDogName(final String keyword) {

        return new Specification<DogInformation>() {
            @Override
            public Predicate toPredicate(Root<DogInformation> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("dogName"), "%" + keyword + "%");
            }
        };
    }

    public static Specification<DogInformation> eqGender(final Code gender) {
        return new Specification<DogInformation>() {
            @Override
            public Predicate toPredicate(Root<DogInformation> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                Predicate equalPredicate = cb.equal(root.get("gender"), gender);
                return equalPredicate;
            }
        };
    }

    public static Specification<DogInformation> eqBoardType(final BoardCategory boardCategory) {
        return new Specification<DogInformation>() {
            @Override
            public Predicate toPredicate(Root<DogInformation> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate equalPredicate = cb.equal(root.get("boardId").get("type"), boardCategory);
                return equalPredicate;
            }
        };
    }

    public static Specification<DogInformation> eqAge(final Code age) {
        return new Specification<DogInformation>() {
            @Override
            public Predicate toPredicate(Root<DogInformation> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate equalPredicate = cb.equal(root.get("age"), age);
                return equalPredicate;
            }
        };
    }

    public static Specification<DogInformation> eqWeight(final Code weight) {
        return new Specification<DogInformation>() {
            @Override
            public Predicate toPredicate(Root<DogInformation> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate equalPredicate = cb.equal(root.get("weight"), weight);
                return equalPredicate;
            }
        };
    }

}