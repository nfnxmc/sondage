import { Injectable } from '@angular/core';
import { ChoiceComponent } from './choice.component';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/range';
import 'rxjs/add/operator/map';
import { HttpClient } from '@angular/common/http';

import * as faker from 'faker';

@Injectable()
export class ChoiceService {
  private id = 0;
  private pollid = -1;
  fakedata = [
    {
      'id': 1,
      'name': 'Choice 0',
      'score': 50,
      'pollId':0
    },
    {
      'id': 2,
      'name': 'Choice 1',
      'score': 150,
      'pollId':0
    },
    {
      'id': 4,
      'name': 'Choice 3',
      'score': 1550,
      'pollId':0
    },
    {
      'id': 3,
      'name': 'Choice 4',
      'score': 250,
      'pollId':0
    }
  ];
  

  randomInt(min, max){
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }
  private fakeChoice() {
    let choice = {selected: false, id: this.id, name: faker.name.firstName(), score: this.randomInt(0, 500), pollId: this.pollid};
    this.id = this.id + 1;
    //console.log(choice);
    return choice;
  }

  fakeChoices(nc: number){
    this.pollid = this.pollid + 1;
    return (new Array<any>(nc).fill(0)).map(i => this.fakeChoice());
  }

  fakePolls():Observable<any>{
    let npoll = this.randomInt(1,20);
    let sizer = (new Array(npoll)).fill(0)
    let ownerId = 0;
    return Observable.of(sizer.map( i => {
      ownerId = ownerId + 1;
      return ({id: this.pollid, ownerId: ownerId, question: faker.lorem.words(2)+'?', choices: this.fakeChoices(this.randomInt(2, 5))});
    }));
  }
  constructor(private http: HttpClient) {
  }


  updateChoiceScore(cid: number, score:number){
    let options = {xrs_token: 'Bearer' + localStorage.getItem('xhr_Token')}
    this.http.post(`/update-choice/?cid={{cid}}&score={{score}}`, options);
  }
}