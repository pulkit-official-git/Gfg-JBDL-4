package CollectionInterface;

import java.util.*;

public class Client {
    public static void main(String[] args) {

//        List<String>list = new ArrayList<>();
//        list.add("AAm");
//        list.add("Ram");
//        list.add("Nam");
//        list.add("Kam");
//        for(String s : list){
//            System.out.println(s);
//        }
//
//        List<String>list2 = new LinkedList<>();
//        list2.add("AAm");
//        list2.add("Ram");
//        list2.add("Nam");
//        list2.add("Kam");
//        for(String s : list2){
//            System.out.println(s);
//        }
//
//        List<String>list3 = new Vector<>();
//        list3.add("AAm");
//        list3.add("Ram");
//        list3.add("Nam");
//        list3.add("Kam");
//        for(String s : list3){
//            System.out.println(s);
//        }
//
//        List<String>list4 = new Stack<>();
//        list4.add("AAm");
//        list4.add("Ram");
//        list4.add("Nam");
//        list4.add("Kam");
//        while(!list4.isEmpty()){
//            System.out.println(list4.getLast());
//            list4.removeLast();
//        }
//
//        Set<String> set = new HashSet<>();
//        set.add("AAm");
//        set.add("Ram");
//        set.add("Nam");
//        set.add("Kam");
//        set.add("AAm");
//        for(String s : set){
//            System.out.println(s);
//        }

//        Set<String> set2 = new LinkedHashSet<>();
//        set2.add("AAm");
//        set2.add("Ram");
//        set2.add("Nam");
//        set2.add("Kam");
//        set2.add("AAm");
//        for(String s : set2){
//            System.out.println(s);
//        }

//        Set<String> set1 = new TreeSet<>();
//        set1.add("AAm");
//        set1.add("Ram");
//        set1.add("Nam");
//        set1.add("Kam");
//        set1.add("AAm");
//        for(String s : set1){
//            System.out.println(s);
//        }

//        Set<PaymentStatus> paymentStatusSet = EnumSet.allOf(PaymentStatus.class);
//        System.out.println(paymentStatusSet);

//        Payment payment1 = new Payment();
//        payment1.setPaymentStatus(PaymentStatus.PENDING);
//        Payment payment2 = new Payment();
//        payment2.setPaymentStatus(PaymentStatus.REJECTED);
//        Payment payment3 = new Payment();
//        payment3.setPaymentStatus(PaymentStatus.DISPUTED);
//        Payment payment4 = new Payment();
//        payment4.setPaymentStatus(PaymentStatus.ACCEPTED);

        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        queue.add("ram");
        queue.add("daniel");
        queue.add("samuel");
        queue.add("fred again");
        queue.add("travis");

        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.poll();
        }





    }
}
