package com.project.restaurant.mappers;

import com.project.restaurant.domain.dtos.PhotoDto;
import com.project.restaurant.domain.entities.Photo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface PhotoMapper {
    PhotoDto toDto(Photo photo);
}
