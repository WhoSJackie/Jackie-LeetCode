package com.wang.learning;//package com.wang.learning;
//
//import com.alibaba.fastjson.JSONObject;
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.text.MessageFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Consumer;
//import java.util.function.Function;
//import java.util.function.Predicate;
//import java.util.function.Supplier;
//import java.util.stream.Collectors;
//
//
//public class Test1 {
//
//
//    @Test
//    public  void test01() {
//        User user=null;
//        Optional<User> option=Optional.ofNullable(user);
//        Assert.assertTrue(option.isPresent());
//        Assert.assertEquals(user.getName(),option.get().getName());
//        String name=option.map(u->u.getName()).orElse("jiamian");
//        System.out.println(name);
//    }
//
//    @Test
//    public void testStream(){
//        List<Integer> list=new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
////        //测试reduce
////        int result=list.stream().reduce(100,(sum,value)->{
////            System.out.println(sum);
////            System.out.println(value);
////            System.out.println("--------");
////            return sum+value;
////        });
////        System.out.println("reduceResult-->"+result);
////
////        //测试map
//        List<Integer> mapList=list.stream().map(i->i*i).collect(Collectors.toList());
//        System.out.println("mapList---->"+mapList);
//        System.out.println("list---->"+list);
////
//        //findFirst()
////        Integer integer = mapList.stream().filter(i -> i.equals(4)).findFirst().get();
////        System.out.println(integer);
//
//        //map
////        List<String> slist= Arrays.asList("123","456","789");
////        slist.stream().map(s->s.length()).forEach(i-> System.out.println(i));
////
//        //flatMap
////        List<String> flist= Arrays.asList("1-2-3","4-5-6");
////        flist.stream().flatMap(i-> Stream.of(i.split("-"))).forEach(a-> System.out.println(a));
////        flist.stream().flatMap(i-> Stream.of(i.split("-"))).min()
//
//        //peek
////        User x=new User("j",1);
////        User y=new User("a",2);
////        User z=new User("v",3);
////        Stream.of(x,y,z).peek(i->{i.setName(i.getName()+i.getAge());}).forEach(i-> System.out.println(i));
//
////        //在并行流下每次返回的结果可能一样也可能不一样,findAny
////        Optional<String> strOption=Stream.of("banana","apple","orange","pineapple").parallel().findAny();
////        strOption.ifPresent(i-> System.out.println(i));
////
////        //min
////        Optional<Integer> min = Stream.of(2, 0, -1, 5, -6, 7).min((e1, e2) -> e1.compareTo(e2));
////        min.ifPresent(i-> System.out.println(i));
//
//
//    }
//
//    @Test
//    public void test02() throws ClassNotFoundException {
////        Class clazz=Class.forName("com.wang.learning.User");
////        System.out.println(clazz.getName());
//
//        //supplier接口
//        Supplier<Integer> supplier=()->{
//            System.out.println("supplier->");
//            return 1024;
//        };
//        System.out.println(supplier.get());
//
//        //consumer接口
//        Consumer<String> consumer=(str)->{
//            System.out.println("consumer->");
//        };
//        consumer.accept("happy");
//
//        //function接口
//        Function<String,String> function=(str)->{
//            System.out.println("function->");
//            return str;
//        };
//        System.out.println(function.apply("sos"));
//
//
//        //predicate
//        Predicate<String> predicate=(str)->{
//            System.out.println("predicate");
//            return str.isEmpty();};
//        System.out.println(predicate.test("abc"));
//
//    }
//
//    @Test
//    public void test03(){
//        BigDecimal num01=new BigDecimal(0.005);
//        BigDecimal num02=new BigDecimal(1000000);
//        BigDecimal num03=new BigDecimal(-1000000);
//
//
//    }
//
//    @Test
//    public void testGeneraics() throws IOException {
//        JSONObject jsonObject=getJSONFromFile("D:\\Code\\Practice\\src\\com\\wang\\learning\\Json\\GetEmployee.json");
//        System.out.println(jsonObject.getJSONObject("request_body"));
//        Client client;
//        WebResource webResource;
//        ClientResponse response;
//
//    }
//
//    private JSONObject getJSONFromFile(String jsonFile) throws IOException {
//        StringBuilder sb = new StringBuilder();
//        BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
//        String line = null;
//
//        for(String flag = ""; (line = reader.readLine()) != null; flag = "\n") {
//            sb.append(flag + line);
//        }
//
//        reader.close();
//        return JSONObject.parseObject(sb.toString());
//    }
//
//    @Test
//    public void testEquals(){
//        String str="$.configTypeForecast()";
//        String methodName=str.substring(str.indexOf("$.")+2,str.indexOf("("));
//        System.out.println(str.substring(("$." + methodName + "(").length(), str.lastIndexOf(")")));
//    }
//
//
//    @Test
//    public void  testMessageFormat(){
//        String name="name";
//        System.out.println(MessageFormat.format("{0} is wang", name));
//    }
//
//    @Test
//    public void testStringFormat(){
//        String str = String.format("exception is :%s",new RuntimeException("ERROR!"));
//        System.out.println(str);
//    }
//
//
//}
