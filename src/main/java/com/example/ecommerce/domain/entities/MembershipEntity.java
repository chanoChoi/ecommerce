package com.example.ecommerce.domain.entities;

import com.example.ecommerce.domain.type.MembershipEnum;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.example.ecommerce.domain.type.MembershipEnum.MEMBER;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "membership")
public class MembershipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private MembershipEnum membershipType;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public static MembershipEntity makeDefaultMember() {
        return MembershipEntity.builder()
                .membershipType(MEMBER)
                .build();
    }
}
