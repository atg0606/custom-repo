package org.privaterepo.dto;

import lombok.Getter;

@Getter
public class ApplicationResponseDto<T> {

    private T data;
}
