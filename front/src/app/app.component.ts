import { Component, OnInit } from '@angular/core';
import { ChoiceService } from './choice/service/choice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  private selectedPoll = {};
  private polls: Array<any> = [{question: 'hi?'}, {question: 'hi?'},{question: 'hi?'},{question: 'hi?'}];;

  constructor(private cs: ChoiceService){}

  ngOnInit(){
    this.cs.fakeChoices().subscribe(choices => {
      this.selectedPoll = { _choices: choices, _ownerId: 0, _id: 0};
    });
  }

  findPolls($event){}
}
