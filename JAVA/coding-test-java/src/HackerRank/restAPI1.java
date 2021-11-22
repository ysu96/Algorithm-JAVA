//package HackerRank;
//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.function.*;
//import java.util.regex.*;
//import java.util.stream.*;
//import static java.util.stream.Collectors.joining;
//import static java.util.stream.Collectors.toList;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.List;
//
//import com.google.gson.Gson;
//
//
//class Result {
//
//
//    public static List<String> getTopRatedFoodOutlets(String city) throws IOException
//    {
//
//        ResponseDto dto = callApi(city, 1);
//        int pages = dto.getTotal_pages();
//        for(int i =)
//        return null;
//    }
//
//    public static int getTotalGoals(String team, int year) {
//        ResponseDto dto = callApi(team, year, 1, true);
//        int goals = 0;
//        for (int i = 1; i <= pages; i++) {
//            goals = goals + callApi(team, year, i, true, false) + callApi(team, year, i, false, false);
//        }
//        return goals;
//    }
//
//    public static ResponseDto callApi(String city, int page) throws IOException {
//        String urlAddress = "https://jsonmock.hackerrank.com/api/food_outlets?city="+city+"&page="+page;
//        String op = "";
//        URL url = new URL(urlAddress);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Accept", "application/json");
//        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
//        String output;
//
//        while ((output = br.readLine()) != null) {
//            op = output;
//            System.out.println(op);
//        }
//        conn.disconnect();
//        Gson gson = new Gson();
//        ResponseDto responseDto = gson.fromJson(op, ResponseDto.class);
//        return responseDto;
//    }
//
////    public static int callApi(String team, int year, int page, boolean isTeam1, boolean isPageCount) {
////        String op = "";
////        Integer goals = 0;
////        String urlAddress;
////        System.out.println(team);
////        String team_new = team.replace(" ", "%20");
////
////        try {
////            if (isTeam1) {
////                urlAddress = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&team1=" + team_new
////                        + "&page=" + page;
////            } else {
////                urlAddress = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&team2=" + team_new
////                        + "&page=" + page;
////            }
////            URL url = new URL(urlAddress);
////            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
////            conn.setRequestMethod("GET");
////            conn.setRequestProperty("Accept", "application/json");
////
////            // if (conn.getResponseCode() != 200) {
////            //     throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
////            // }
////            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
////            String output;
////
////            while ((output = br.readLine()) != null) {
////                op = output;
////                System.out.println(op);
////            }
////            conn.disconnect();
////
////        } catch (MalformedURLException e) {
////            e.printStackTrace();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////        Gson gson = new Gson();
////        Test thing = gson.fromJson(op, Test.class);
////        if (isPageCount) {
////            return thing.getTotal_pages();
////        } else {
////            if (thing.getData() != null && !thing.getData().isEmpty()) {
////
////                for (Data a : thing.getData()) {
////                    System.out.println(a.getTeam1());
////                    System.out.println(team);
////                    System.out.println(team.toLowerCase().equals(a.getTeam1().toLowerCase()));
////                    if (isTeam1 && team.toLowerCase().equals(a.getTeam1().toLowerCase())) {
////                        goals += Integer.parseInt(a.getTeam1goals());
////
////                    }
////                    if (!isTeam1 && team.toLowerCase().equals(a.getTeam2().toLowerCase())) {
////                        goals += Integer.parseInt(a.getTeam2goals());
////                    }
////                }
////            }
////        }
////        return goals;
////    }
////
////}
//class ResponseDto {
//    private Integer page;
//    private Integer per_page;
//    private Integer total;
//    private Integer total_pages;
//    private List<Data> data;
//    public Integer getPage() {
//        return page;
//    }
//
//    public void setPage(Integer page) {
//        this.page = page;
//    }
//    public Integer getPer_page() {
//        return per_page;
//    }
//    public void setPer_page(Integer per_page) {
//        this.per_page = per_page;
//    }
//    public Integer getTotal() {
//        return total;
//    }
//    public void setTotal(Integer total) {
//        this.total = total;
//    }
//    public Integer getTotal_pages() {
//        return total_pages;
//    }
//    public void setTotal_pages(Integer total_pages) {
//        this.total_pages = total_pages;
//    }
//    public List<Data> getData() {
//        return data;
//    }
//    public void setData(List<Data> data) {
//        this.data = data;
//    }
//}
//class Data {
//    private String city;
//    private String name;
//    private Integer estimated_cost;
//    private UserRating user_rating;
//    private Integer id;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getEstimated_cost() {
//        return estimated_cost;
//    }
//
//    public void setEstimated_cost(Integer estimated_cost) {
//        this.estimated_cost = estimated_cost;
//    }
//
//    public UserRating getUser_rating() {
//        return user_rating;
//    }
//
//    public void setUser_rating(UserRating user_rating) {
//        this.user_rating = user_rating;
//    }
//}
//class UserRating{
//    private Float average_rating;
//    private Integer votes;
//
//    public Float getAverage_rating() {
//        return average_rating;
//    }
//
//    public void setAverage_rating(Float average_rating) {
//        this.average_rating = average_rating;
//    }
//
//    public Integer getVotes() {
//        return votes;
//    }
//
//    public void setVotes(Integer votes) {
//        this.votes = votes;
//    }
//}
////class Test {
////    private Integer page;
////    private Integer per_page;
////    private Integer total;
////    private Integer total_pages;
////    private List<Data> data;
////
////    public Integer getPage() {
////        return page;
////    }
////
////    public void setPage(Integer page) {
////        this.page = page;
////    }
////
////    public Integer getPer_page() {
////        return per_page;
////    }
////
////    public void setPer_page(Integer per_page) {
////        this.per_page = per_page;
////    }
////
////    public Integer getTotal() {
////        return total;
////    }
////
////    public void setTotal(Integer total) {
////        this.total = total;
////    }
////
////    public Integer getTotal_pages() {
////        return total_pages;
////    }
////
////    public void setTotal_pages(Integer total_pages) {
////        this.total_pages = total_pages;
////    }
////
////    public List<Data> getData() {
////        return data;
////    }
////
////    public void setData(List<Data> data) {
////        this.data = data;
////    }
////}
////
////class Data {
////    private String team1;
////    private String team2;
////    private String team1goals;
////    private String team2goals;
////
////    public String getTeam1() {
////        return team1;
////    }
////
////    public void setTeam1(String team1) {
////        this.team1 = team1;
////    }
////
////    public String getTeam2() {
////        return team2;
////    }
////
////    public void setTeam2(String team2) {
////        this.team2 = team2;
////    }
////
////    public String getTeam1goals() {
////        return team1goals;
////    }
////
////    public void setTeam1goals(String team1goals) {
////        this.team1goals = team1goals;
////    }
////
////    public String getTeam2goals() {
////        return team2goals;
////    }
////
////    public void setTeam2goals(String team2goals) {
////        this.team2goals = team2goals;
////    }
////
////}
//
//public class restAPI1 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String team = bufferedReader.readLine();
//
//        int year = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int result = Result.getTotalGoals(team, year);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
