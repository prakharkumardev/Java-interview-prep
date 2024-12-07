package dev.harsh.hashmap;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LinkedListNode <V>{
    private String key;
    private V value;
    private LinkedListNode<V> next;
}
