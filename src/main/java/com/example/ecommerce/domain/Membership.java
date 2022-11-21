package com.example.ecommerce.domain;

import com.example.ecommerce.type.MembershipEnum;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.example.ecommerce.type.MembershipEnum.MEMBER;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private MembershipEnum membershipType;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public static Membership makeDefaultMember() {
        return Membership.builder()
                .membershipType(MEMBER)
                .build();
    }
}
