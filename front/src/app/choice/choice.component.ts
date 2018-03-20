import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ChoiceService } from './service/choice.service';
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
  @Output("newScore") newScore = new EventEmitter<any>();

  ngOnInit(): void {
    
  }
  constructor(private cs: ChoiceService){}

  increment(){
    this.score = this.score + 1;
    this.newScore.emit({id: this.id, score: this.score});
  }
  updateScore(){
    this.increment();
    this.cs.updateChoiceScore(this.score);
  }

}
