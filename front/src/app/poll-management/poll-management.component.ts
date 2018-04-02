import { Component, OnInit, Input } from '@angular/core';
import { ChoiceService } from '../choice/choice.service';

@Component({
  selector: 'app-poll-management',
  templateUrl: './poll-management.component.html',
  styleUrls: ['./poll-management.component.css']
})
export class PollManagementComponent implements OnInit {
  private selectedPoll : any;
  private polls: Array<any>;
  private _polls: Array<any>;
  @Input('keywords') keywords: string;

  constructor(private cs: ChoiceService){}

  ngOnInit(){
    this.cs.fakePolls().subscribe(
      data => {this.polls = data; this._polls = data; this.selectedPoll = data[0];}
    )
  }

  filterPolls($event){
    if(this.keywords){
      this.polls = this._polls.filter(poll => {
        return poll.question.includes(this.keywords);
      })
    }
    else {
      this.polls = this._polls;
    }
  }
  reloadChoices(event){
    this.selectedPoll = this.selectedPoll.map(p =>({
      choices: event, 
      ownerId:p.ownerId,
      id: p.id,
      question: p.question
    }));
    console.log("selected poll => ", this.selectedPoll);
  }
  setSelectedPoll(event) {
    this.selectedPoll = this._polls.filter( poll => poll.question === event.target.innerText)[0];
    //console.log(this.selectedPoll);
  }

}
