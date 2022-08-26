package com.nttdata.bootcamp.bank.springboot.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection="location")
public class Location {

    @Id
    private String id;

    @Builder.Default
    private String codeLocation = "";

    @Builder.Default
    private String name = "";

    @Builder.Default
    private String description = "";

    @Builder.Default
    private String state = "";

    @Builder.Default
    private String codeLocationType = "";

    @Builder.Default
    private String codeUbigeo = "";

}
