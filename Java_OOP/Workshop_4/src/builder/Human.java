package builder;

public class Human {
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final String address;
    private final String postCode;

    private Human(String firstName, String lastName, Integer age, String address, String postCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.postCode = postCode;
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private String firstName;
        private String lastName;
        private Integer age;
        private String address;
        private String postCode;

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withPostalCode(String postalCode) {
            this.postCode = postalCode;
            return this;
        }

        public Human build() {
            return new Human(firstName, lastName, age, address, postCode);
        }
    }
}
