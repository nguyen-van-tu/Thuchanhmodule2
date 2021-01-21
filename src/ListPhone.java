
    public class ListPhone {
        private String numberPhone;
        private String group;
        private String name;
        private String gender;
        private String address;
        private String DateOfBirth;
        private String Email;

        public ListPhone(String numberPhone, String group, String name, String sex, String address, String dateOfBirth, String email) {
            this.numberPhone = numberPhone;
            this.group = group;
            this.name = name;
            this.gender = sex;
            this.address = address;
            DateOfBirth = dateOfBirth;
            Email = email;
        }

        public ListPhone() {
        }

        public String getNumberPhone() {
            return numberPhone;
        }

        public void setNumberPhone(String numberPhone) {
            this.numberPhone = numberPhone;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }


        public void setGender(String sex) {
            this.gender = sex;
        }


        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDateOfBirth() {
            return DateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            DateOfBirth = dateOfBirth;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        @Override
        public String toString() {
            return "ListPhone{" +
                    "numberPhone='" + numberPhone + '\'' +
                    ", group='" + group + '\'' +
                    ", name='" + name + '\'' +
                    ", sex='" + gender + '\'' +
                    ", address='" + address + '\'' +
                    ", DateOfBirth='" + DateOfBirth + '\'' +
                    ", Email='" + Email + '\'' +
                    '}';
        }
    }


