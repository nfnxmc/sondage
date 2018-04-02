import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ChoiceComponent } from '../choice/choice.component';
import { ChoiceService } from '../choice/service/choice.service';
import { Observable } from 'rxjs/Observable';




@Component({
  selector: 'app-poll',
  templateUrl: './poll.component.html',
  styleUrls: ['./poll.component.css']
})
export class PollComponent implements OnInit {
 
  // Drawable data
  private disabled: boolean = true;
  private colors = ["#66ffff", "#6699ff", "#ffccff"];

  // model data
  @Input('choices') choices: Array<any>;
  @Input('ownerId') ownerId: number;
  @Input('id') id: number;
  @Input() question: string = "Your choice?";
  private errorMessage:string = "";

  @Output('choices') _choices = new EventEmitter<any>();

  constructor(private choiceService: ChoiceService) { }

  ngOnInit() {
  }

  updateChoiceScore(cid: number){
    this.choiceService.updateChoiceScore(cid);
    this.disabled = true;
  }

  results(): Array<any>{
    return this.choices.map(c => ({name: c.name, value: c.score}));
  }
    
  loadNewScore(event) {
   
    this.choices.map(choice => {
      if(choice.id == event.id){
        choice.score = event.score;
      }
    });
    
    this._choices.emit(this.choices);

  }
    
   
}
