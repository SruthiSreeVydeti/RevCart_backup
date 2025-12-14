import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  template: `
    <div>
      <h1>RevCart E-commerce</h1>
      <p>Application is loading...</p>
      <router-outlet></router-outlet>
    </div>
  `
})
export class AppComponent {
  title = 'RevCart';
}