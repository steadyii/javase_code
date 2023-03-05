package com.steady.d9_lambda.sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


@SpringBootTest
public class SortTest {
    /**
     * Arrays.sort 对未实现compare的类数组排序
     */
    @Test
    void sortArray() {
        Person[] p = {new Person("xx", 11), new Person("yy", 14), new Person("vv", 10)};
        Arrays.sort(p, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        
        Arrays.sort(p, (o1, o2) -> o1.getAge() - o2.getAge());
        
        Arrays.sort(p,
                Comparator
                        .comparingInt(Person::getAge)
                        .thenComparing(Person::getName)
        );
        
        for (Person person : p) {
            System.out.println(person);
        }
    }
    
    /**
     * list.sort 对未实现compare的类链表排序
     */
    @Test
    void sortList() {
        List<UserEntity> list = Arrays.asList(new UserEntity("xx", 12), new UserEntity("uu", 14), new UserEntity("zz", 15));
        list.sort(new Comparator<UserEntity>() {
            @Override
            public int compare(UserEntity o1, UserEntity o2) {
                return o1.age - o2.age;
            }
        });
        
        list.sort((o1, o2) -> o1.age - o2.age);
        
        list.sort(Comparator.comparingInt(o -> o.age));
    }
    
    /**
     * 对实现comparable的类数组进行排序
     */
    @Test
    void sortComparable() {
        Entity[] entities = {new Entity("xx", 11), new Entity("yy", 14), new Entity("vv", 10)};
        Arrays.sort(entities);
        System.out.println(Arrays.toString(entities));
    }
}

@Data
@AllArgsConstructor
class Person {
    private String name;
    private int age;
}


/**
 * 实现Comparable的类,可以直接比较
 */
@Data
@AllArgsConstructor
class Entity implements Comparable<Entity> {
    private String name;
    private int age;
    
    @Override
    public int compareTo(Entity o) {
        return this.age - o.age;
    }
}
