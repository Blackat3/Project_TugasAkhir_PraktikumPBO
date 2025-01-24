package Model;

    public abstract class User {
        String username;
        String password;
        private String noHp;
        private String alamat;

        public User(String username, String password, String noHp, String alamat) {
            this.username = username;
            this.password = password;
            this.noHp = noHp;
            this.alamat = alamat;
        }
    public String getUsername() {
        return username;
    }

    public abstract boolean login(String username, String password);
}