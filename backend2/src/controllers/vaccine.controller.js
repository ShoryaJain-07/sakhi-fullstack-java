import { asyncHandler } from "../utils/asyncHandler.js";
import { Vaccine } from "../models/vaccine.model.js";
import { ApiResponse } from "../utils/ApiResponse.js";

export const addVaccine = asyncHandler(async (req, res) => {
  try {
    const {userId} = req.body
    const vaccine = await Vaccine.create({
      userId,
      name: req.body.name,
      date:req.body.date
    });

    if (!vaccine) {
      return res.json(new ApiResponse(400, error, "Vaccine not created"));
    }

    return res.json(
      new ApiResponse(200, vaccine, "Vaccine added successfully")
    );
  } catch (error) {
    return res.json(new ApiResponse(500, error, "internal server error"));
  }
});

export const getVaccine = asyncHandler(async (req, res) => {
  try {
    const { userId } = req.params;
    const vaccines = await Vaccine.find({ userId });

    if (!vaccines) {
      return res.json(new ApiResponse(400, error, "Vaccine not found"));
    }
    
    return res.json(
      new ApiResponse(200, vaccines, "Vaccine fetched successfully")
    );
  } catch (error) {
    return res.json(new ApiResponse(500, error, "internal server error"));
  }
});
