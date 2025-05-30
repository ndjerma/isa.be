package com.example.demo.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class UserPageModel {
    private List<UserModel> Users;
    private Integer totalPages;
    private Long totalElements;
}
