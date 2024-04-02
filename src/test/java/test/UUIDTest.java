package test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class UUIDTest {
    public static void main(String[] args) {
        List<?> uuids = IntStream
                           .range(0, 100)
                           .mapToObj(uuid -> genUuid())
                           .toList();

        System.out.println(uuids);
    }


    public static String genUuid() {
        return String.join("", UUID.randomUUID().toString().split("-"));
    }
}
