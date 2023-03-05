package com.steady.d15_stream;

import com.steady.d9_lambda.sort.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
public class StreamTest {
    @Test
    void test() {
        List<UserEntity> list = Arrays.asList(
                new UserEntity("xx", 12),
                new UserEntity("uu", 14),
                new UserEntity("zz", 15),
                new UserEntity("oo", 33),
                new UserEntity("uu", 14)
        );
        
        List<UserEntity> collect = list.stream()
                .filter(Objects::nonNull)
                .filter(o -> o.getAge() > 13)
                .distinct()          //equals����,�ɹ�ȥ��
                .sorted(Comparator.comparingInt(UserEntity::getAge))        //����
                .collect(Collectors.toList());   //���� .collect(Collectors<?>) �ռ�,Ҳ����ת������
        System.out.println(collect);
    }
    
    @Test
    void test1() {
        List<String> list = Arrays.asList("aaaa", "sd", "xx", "add", "lwd", "Sad");
        
        list = list.stream()
                .filter(s -> s.length() >= 3)              //filter,��������������
                .filter(s -> s.charAt(0) >= 'A' && s.charAt(0) <= 'Z')
                .distinct()
                .collect(Collectors.toList());
        
        System.out.println(list);
        System.out.println(list.toArray().length);
    }
    
    @Test
    void test2() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list = list
                .stream()
                .distinct()
                .filter(e -> !e.equals("B"))
                .limit(2)
                .collect(Collectors.toList());
        
        System.out.println(list);
    }
}

