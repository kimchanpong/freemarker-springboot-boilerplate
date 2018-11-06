package com.ckdpharm.homepage.model.main;

import com.ckdpharm.homepage.model.common.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MainPO extends BaseModel<MainPO> {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String firstName;
    private String lastName;
}
