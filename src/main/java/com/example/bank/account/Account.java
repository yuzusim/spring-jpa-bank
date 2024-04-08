package com.example.bank.account;

import com.example.bank.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Table(name = "accout_tb")
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(unique = true, nullable = false, length = 4)
    private Integer number; // 1111, 2222
    // 전화번호나 계좌번호 스트링으로 만드는게 낫다.

    @Column(nullable = false, length = 4)
    private String password;

    @Column(nullable = false)
    private Long balance; // 잔액

    private Boolean status; // true, false, 여러가지가 있으면 String 타입으로 해야함
    // 계좌번호에 히스토리 삭제하면 망함
    //

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public Account(Long id, User user, Integer number, String password, Long balance, Boolean status, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.number = number;
        this.password = password;
        this.balance = balance;
        this.status = status;
        this.createdAt = createdAt;
    }
}


