import mongoose, { Schema } from "mongoose";

const quizSchema = new Schema({
  question: {
    type: String,
  },
  option1: {
    type: String,
  },
  option2: {
    type: String,
  },
  option3: {
    type: String,
  },
  option4: {
    type: String,
  },
  answer: {
    type: String,
  },
});

export const Quiz = mongoose.model("Quiz", quizSchema);
