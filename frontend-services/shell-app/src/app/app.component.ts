import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [],
  template: `
    <div>
      <h1>RevCart E-commerce</h1>
      <p>Minimal app - NO routing, NO services, NO dependencies</p>
      <p>If you see this, Angular is working!</p>
    </div>
  `
})
export class AppComponent {
  title = 'RevCart';
}