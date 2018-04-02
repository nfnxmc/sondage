export class Choice {
    _id     : number;
    _name   : string;
    _score  : number;
    _pollId : number;

    constructor(id:number, name:string, score:number, pollId:number){
        this._id        = id;
        this._name      = name;
        this._score     = score;
        this._pollId    = pollId;
    }

    get id():number{
        return this._id;
    }
    get name():string {
        return this._name;
    }
    get score(): number {
        return this._score;
    }
    get pollId(): number {
        return this._pollId;
    }
    set id(id:number){
        this._id = id;
    }
    set name(name:string){
        this._name = name;
    }
    set score(score:number){
        this._score = score;
    }
    set pollId(pollId:number){
        this._pollId = pollId;
    }
}

export class Poll {
    _question   : string;
    _id         : number;
    _choices    : Array<Choice>;
    _ownerId    : number;
    constructor(id:number, question:string, ownerId: number, choices: Array<Choice>){
        this._id        = id;
        this._question  = question;
        this._ownerId   = ownerId;
        this._choices   = choices;
    }

    addchoice(choice: Choice){
        this._choices.push(choice);
    }
}

export class User {
    _id         : number;
    _name       : string;
    _email      : string;
    _password   : string;
    _imgUrl     : string;
    constructor(id:number,name:string,email:string,password:string, imgUrl ?:string){
        this._id        = id;
        this._name      = name;
        this._email     = email;
        this._password  = password;
        this._imgUrl    = imgUrl;
    }
}

