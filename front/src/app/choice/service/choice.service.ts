import { Injectable } from '@angular/core';
import { ChoiceComponent } from '../choice.component';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';



@Injectable()
export class ChoiceService {
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
      'score': 550,
      'pollId':0
    },
    {
      'id': 3,
      'name': 'Choice 4',
      'score': 250,
      'pollId':0
    }
  ];
  fakeChoices(): Observable<any>{
    
    return Observable.of(this.fakedata);
  }
  constructor() { }


  updateChoiceScore(cid: number){
    throw new Error("not implemented yet!!");
  }
}
