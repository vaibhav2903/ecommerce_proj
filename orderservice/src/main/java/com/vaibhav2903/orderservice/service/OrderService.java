package com.vaibhav2903.orderservice.service;

import com.vaibhav2903.orderservice.dto.OrderLineItemsDto;
import com.vaibhav2903.orderservice.dto.OrderRequest;
import com.vaibhav2903.orderservice.model.Order;
import com.vaibhav2903.orderservice.model.OrderLineItems;
import com.vaibhav2903.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNo(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this:: maptoDto)
                .toList();

        order.setItems(orderLineItems);
        orderRepository.save(order);

    }

    private OrderLineItems maptoDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
