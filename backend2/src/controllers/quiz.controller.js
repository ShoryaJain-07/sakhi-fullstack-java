import { asyncHandler } from "../utils/asyncHandler.js"
import {Quiz} from "../models/quiz.model.js"
import { ApiResponse } from "../utils/ApiResponse.js";

export const addQuiz = asyncHandler(async (req, res) => {
  try {
      const {question, option1, option2, option3, option4, answer} = req.body
        const quiz = await Quiz.create({
          question,
          option1,
          option2,
          option3,
          option4,
          answer,
        });

        if (!quiz) {
            return res.json(
              new ApiResponse(400, error, "quiz not created")
            );
        }

        return res.json(new ApiResponse(200, quiz, "Quiz added successfully"));
    } catch (error) {
        return res.json(
          new ApiResponse(500, error, "internal server error")
        );
    }
})

export const getQuiz = asyncHandler(async (req, res) => {
  try {
    const quiz = await Quiz.find();

    if (!quiz) {
      return res.json(new ApiResponse(400, error, "Quiz not found"));
    }

    return res.json(new ApiResponse(200, quiz, "Quiz fetched successfully"));
  } catch (error) {
    return res.json(new ApiResponse(500, error, "internal server error"));
  }
});