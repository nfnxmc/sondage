import { Component, OnInit, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { ChoiceComponent } from '../choice/choice.component';
import { ChoiceService } from '../choice/choice.service';
import { Observable } from 'rxjs/Observable';




@Component({
  selector: 'app-poll',
  templateUrl: './poll.component.html',
  styleUrls: ['./poll.component.css']
})
export class PollComponent implements OnInit, OnChanges {
 
  totalScore: number;
  ngOnChanges(changes: SimpleChanges): void {
    this.selectedChoiceId = -1;
  }
  // Drawable data
  private disabled: boolean = true;
  private colors = ["#66ffff", "#6699ff", "#ffccff"];

  // model data
  @Input('choices') choices: Array<any>;
  @Input('ownerId') ownerId: number;
  @Input('id') id: number;
  @Input() question: string = "Your choice?";

  // Selected choice infos
  private selectedChoiceId=-1;
  private selectedChoiceScore = -1;

  // Voting information
  private viewresult = false;
 
  private errorMessage:string = "";


  @Output('choices') _choices = new EventEmitter<any>();

  constructor(private choiceService: ChoiceService) { }

  ngOnInit() {
    this.selectedChoiceId=-1;
  }

  private isVoted() {
    return localStorage.getItem('poll'+ this.id + this.question) != undefined;
  }
  updateChoiceScore(cid: number, score:number){
    this.choiceService.updateChoiceScore(cid, score);
    this.disabled = false;
  }

  showResults() {
    this.viewresult = !this.viewresult;
    this.totalScore = 0;
    this.choices.forEach(choice => this.totalScore += choice.score);
  }
  percentage(score){
    return score + '%';
  }

  
  validateSelection(){
    if(this.selectedChoiceId != -1) {
      this.choiceService.updateChoiceScore(this.selectedChoiceId, this.selectedChoiceScore + 1);
      localStorage.setItem('poll' + this.id + this.question, 'true');
    }
  }

  cancelSelection(){
    this.selectedChoiceId = -1;
    this.choices = this.choices.map(choice => {
      choice.selected = false;
      return choice;
    })
  }
    
  choiceSelected(event) {
    
    this.choices = this.choices.map(choice => {
      if(choice.id == event.id){
        this.selectedChoiceId = event.id;
        this.selectedChoiceScore = event.score;
        choice.score = event.score;
        choice.selected = true;
        return choice;
      }
      else {
        choice.selected = false;
        return choice;
      }
    });
    
    this._choices.emit(this.choices);

  }
    
   
}