import { Router } from "express";
import { addQuiz, getQuiz } from "../controllers/quiz.controller.js";

const router = Router();

router.route("/add-quiz").post(addQuiz);
router.route("/get-quiz").get(getQuiz);

export default router;
