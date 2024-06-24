import mongoose, { Schema } from "mongoose";

const vaccineSchema = new Schema({
  userId: {
    type: Schema.Types.ObjectId,
    ref: "user",
  },
  name: {
    type: String,
  },
  date: {
    type: Date,
  },
});

export const Vaccine = mongoose.model("Vaccine", vaccineSchema);
