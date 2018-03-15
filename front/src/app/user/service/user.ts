
export class User {
    private isLoggedIn = false;

    constructor(private _email:string, private _password:string, private _name:string){}

    set email(email:string){
        this._email = email;
    }
    set password(password:string){
        this._email = password;
    }
    set name(name:string){
        this.name = name;
    }

    get email(): string{
        return this._email;
    }
    get password():string {
        return this._password;
    }
    get name(): string{
        return this._name;
    }

    changeStatus(){
        this.isLoggedIn = !this.isLoggedIn;
    }
}

