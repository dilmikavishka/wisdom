package lk.ijse.gdse.dto;

public class User {
        private String UserName;

        public User(String name) {
            this.setName(name);
        }

        public String getName() {
            return this.UserName;
        }


        public void setName(String name) {
            this.UserName = name;
        }

}
