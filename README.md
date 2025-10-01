# Voting System

A simple online voting system built with React and Spring Boot to manage elections, candidates, and votes efficiently.

# Features

1. Create and manage elections

2. Add and manage candidates

3. Users can vote for candidates

4. View election results in real-time

5. Responsive UI for desktop and mobile

#Tech Stack

1. Frontend: React, HTML5, CSS3, JavaScript

2. Backend: Spring Boot, Java

3. Database: MySQL / H2

4. Other: RESTful APIs, JSON

Installation & Setup

Clone the repo:

git clone https://github.com/yourusername/voting-system.git


# Backend:

cd voting-system/backend
mvn spring-boot:run


# Frontend:

cd voting-system/frontend
npm install
npm start


# Open your browser at http://localhost:3000.

Project Structure
voting-system/
├── backend/      # Spring Boot backend
├── frontend/     # React frontend
└── README.md     # Project documentation

API Endpoints
Endpoint	Method	Description
/api/elections	GET	Fetch all elections
/api/candidates	GET	Fetch all candidates
/api/votes	POST	Submit a vote
/api/results	GET	Fetch election results

# Usage

Admin can add elections and candidates

Users can vote for candidates

Results are displayed after voting
