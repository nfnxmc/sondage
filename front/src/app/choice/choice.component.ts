import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ChoiceService } from './choice.service';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-choice',
  templateUrl: './choice.component.html',
  styleUrls: ['./choice.component.css']
})
export class ChoiceComponent implements OnInit {
  @Input('id') id: number;
  @Input('name') name : string;
  @Input('score') score: number;
  @Input('pollId') pollId: number;
  @Output("choiceSelected") choiceSelected = new EventEmitter<any>();
  @Input("selected") selected : boolean;

  ngOnInit(): void {
    
  }
  constructor(private cs: ChoiceService){}

  data(){
    return {id: this.id, name: this.name, score: this.score, pollId: this.pollId, selected: this.selected};
  }
  changeclass() {
    //console.log(this.id + ' is selected');
    this.choiceSelected.emit(this.data());
  }
  increment(){
    this.score = this.score + 1;
  }
  updateScore(){
    this.increment();
    this.cs.updateChoiceScore(this.id, this.score);
  }

}