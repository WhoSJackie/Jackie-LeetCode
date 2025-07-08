package com.wang.java_Learning.encode;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;

public class TestEncode {


    public static void base64Test(){
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=");
        System.out.println(new String(apiKeySecretBytes));
    }


    public static void main(String[] args) {
//        System.out.println(StandardCharsets.UTF_8.displayName());
//        base64Test();
        String str = "bearer_eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhZG1pblVpZCI6IjFmMDFjZDFkMmY0NzQ3NDNiMjQxZDc0MDA4YjEyMzMzIiwicm9sZSI6Im51bGzotoXnuqfnrqHnkIYiLCJjcmVhdGVUaW1lIjoxNzQ1NzU5MjIyNTUxLCJzdWIiOiJhZG1pbiIsImlzcyI6Im1vZ3VibG9nIiwiYXVkIjoiMDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjYiLCJleHAiOjE3NDU3NjY0MjIsIm5iZiI6MTc0NTc1OTIyMn0.qWK4J2waCaGpzAN3Qwb1fcK20UAwZiRcqEaDz0mi21s";
        System.out.println(str.length());
    }
}
