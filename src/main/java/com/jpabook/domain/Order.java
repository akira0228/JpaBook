package com.jpabook.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems = new ArrayList<>();

    private Delivery delivery;

    private LocalDateTime orderDate; //주문시간

    private OrderStatus status; //주문의 상태[order, cancel]

}
