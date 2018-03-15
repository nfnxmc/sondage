import { Component, OnInit, Input } from '@angular/core';

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

  ngOnInit(): void {
    
  }
  constructor(){}


}
