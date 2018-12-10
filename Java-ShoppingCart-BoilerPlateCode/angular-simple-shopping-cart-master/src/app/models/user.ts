export class User {
    public id?: number = 0;
    public username: string= "";
    public password: string= "";
    public firstname?: string= "Guest";

    constructor(username?: string, password?: string) {
        this.username = username;
        this.password = password;
    }
}
