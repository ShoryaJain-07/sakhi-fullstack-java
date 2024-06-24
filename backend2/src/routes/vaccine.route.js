import { Router } from "express";
import {addVaccine, getVaccine} from "../controllers/vaccine.controller.js"

const router = Router();

router.route("/add-vaccine").post(addVaccine);
router.route("/get-vaccine/:userId").get(getVaccine);

export default router;
