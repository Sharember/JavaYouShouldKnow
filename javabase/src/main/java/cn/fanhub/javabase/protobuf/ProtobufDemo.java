package cn.fanhub.javabase.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Arrays;

public class ProtobufDemo {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        SearchRequestOuterClass.SearchRequest request = SearchRequestOuterClass.SearchRequest
                .newBuilder()
                .setPageNumber(1)
                .setQuery("test")
                .setResultPerPage(5)
                .build();

        //序列化方式一
        System.out.println(request.toByteString());

        //反序列化方式一
        SearchRequestOuterClass.SearchRequest newReq = SearchRequestOuterClass.SearchRequest.parseFrom(request.toByteString());
        System.out.println(newReq.getQuery());

        //序列化方式二
        System.out.println(Arrays.toString(request.toByteArray()));
        //反序列化方式二
        newReq = SearchRequestOuterClass.SearchRequest.parseFrom(request.toByteArray());
        System.out.println(newReq.getQuery());
    }
}