//public class PathfinderAPI {
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
//    class Result
//    {
//
//        /*
//         * Complete the 'getTopRatedFoodOutlets' function below.
//         *
//         * URL for cut and paste
//         * https://jsonmock.hackerrank.com/api/food_outlets?city=<city>&page=<pageNumber>
//         *
//         * The function is expected to return an array of strings.
//         *
//         * The function accepts only city argument (String).
//         */
//
//        public static List<String> getTopRatedFoodOutlets(String city) throws IOException
//        {
//            List<String> answer = new ArrayList<>();
//            ResponseDto dto = callApi(city, 1);
//            int pages = dto.getTotal_pages();
//            float maxRate = 0;
//            for(int i =1; i<=pages; i++){
//                ResponseDto response = callApi(city, i);
//                if(!response.getData().isEmpty()){
//                    for (Data data : response.getData()) {
//                        float rate = data.getUser_rating().getAverage_rating();
//                        if(maxRate < rate) maxRate = rate;
//                    }
//                }
//            }
//
//            for(int i =1; i<=pages; i++){
//                ResponseDto response = callApi(city, i);
//                if(!response.getData().isEmpty()){
//                    for (Data data : response.getData()) {
//                        if(data.getUser_rating().getAverage_rating() == maxRate){
//                            answer.add(data.getName());
//                        }
//
//                    }
//                }
//            }
//
//            return answer;
//        }
//
//        public static ResponseDto callApi(String city, int page) throws IOException {
//            String urlAddress = "https://jsonmock.hackerrank.com/api/food_outlets?city="+city+"&page="+page;
//            String op = "";
//            URL url = new URL(urlAddress);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");
//            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
//            String output;
//
//            while ((output = br.readLine()) != null) {
//                op = output;
//                //System.out.println(op);
//            }
//            conn.disconnect();
//            Gson gson = new Gson();
//            ResponseDto responseDto = gson.fromJson(op, ResponseDto.class);
//            return responseDto;
//        }
//
//    }
//
//    class ResponseDto {
//        private Integer page;
//        private Integer per_page;
//        private Integer total;
//        private Integer total_pages;
//        private List<Data> data;
//        public Integer getPage() {
//            return page;
//        }
//
//        public void setPage(Integer page) {
//            this.page = page;
//        }
//        public Integer getPer_page() {
//            return per_page;
//        }
//        public void setPer_page(Integer per_page) {
//            this.per_page = per_page;
//        }
//        public Integer getTotal() {
//            return total;
//        }
//        public void setTotal(Integer total) {
//            this.total = total;
//        }
//        public Integer getTotal_pages() {
//            return total_pages;
//        }
//        public void setTotal_pages(Integer total_pages) {
//            this.total_pages = total_pages;
//        }
//        public List<Data> getData() {
//            return data;
//        }
//        public void setData(List<Data> data) {
//            this.data = data;
//        }
//    }
//    class Data {
//        private String city;
//        private String name;
//        private Integer estimated_cost;
//        private UserRating user_rating;
//        private Integer id;
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//        public String getCity() {
//            return city;
//        }
//
//        public void setCity(String city) {
//            this.city = city;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public Integer getEstimated_cost() {
//            return estimated_cost;
//        }
//
//        public void setEstimated_cost(Integer estimated_cost) {
//            this.estimated_cost = estimated_cost;
//        }
//
//        public UserRating getUser_rating() {
//            return user_rating;
//        }
//
//        public void setUser_rating(UserRating user_rating) {
//            this.user_rating = user_rating;
//        }
//    }
//    class UserRating{
//        private Float average_rating;
//        private Integer votes;
//
//        public Float getAverage_rating() {
//            return average_rating;
//        }
//
//        public void setAverage_rating(Float average_rating) {
//            this.average_rating = average_rating;
//        }
//
//        public Integer getVotes() {
//            return votes;
//        }
//
//        public void setVotes(Integer votes) {
//            this.votes = votes;
//        }
//    }
//}
